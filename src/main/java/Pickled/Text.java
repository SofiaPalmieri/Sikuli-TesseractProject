package Pickled;

import PickledExceptions.PickledSUTException;
import PickledExceptions.PickledTimeOutException;
import net.sourceforge.tess4j.*;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.List;

public class Text extends ScreenElement{

    private final String textToFind;

    public Text(String textToFind){

        this.textToFind = textToFind;
    }

    public Text(Rectangle readLocation)  {
        try {
            ITesseract tesseract = DependencyHandler.getInstance().getTesseract();
            BufferedImage screen = new PickledRobot().getCroppedScreen(readLocation);
            this.textToFind = tesseract.doOCR(screen);
        } catch (TesseractException t){
            throw new PickledSUTException();
        }
    }

    @Override
    public Rectangle find(double wait) throws PickledTimeOutException, PickledSUTException {

        long limit = this.getTimeoutLimit(wait);
        while(this.notTimedOut(limit)) {
            BufferedImage screen = new PickledRobot().getCurrentScreen();
            ITesseract instance = DependencyHandler.getInstance().getTesseract();

            List<Word> wordBoxes = instance.getWords(screen, ITessAPI.TessPageIteratorLevel.RIL_WORD);
            List<String> wordsToFind = List.of(this.textToFind.split(" "));
            Rectangle rect =  findBox(null,wordBoxes,wordsToFind);
            if (rect != null) return rect;
        }

        throw new PickledTimeOutException();
    }


    private Rectangle findBox(Rectangle startingRect,List<Word> availableWords, List<String> wordsToFind){
        if (wordsToFind.size() == 0) return startingRect;

        String wordToFind = wordsToFind.get(0);

        List<Word> matches = availableWords.stream().filter((Word w) -> w.getText().toLowerCase().contains(wordToFind.toLowerCase())).toList();

        for(Word match : matches) {

          if (startingRect == null) {
              Rectangle boundingRectangle = findBox(match.getBoundingBox(),availableWords,wordsToFind.subList(1,wordsToFind.size()));

              if (boundingRectangle != null) {
                  return boundingRectangle;
              }

          } else {
              Rectangle matchRectangle = match.getBoundingBox();

              if (Math.sqrt(Math.pow(startingRect.x + startingRect.width - matchRectangle.x, 2) + Math.pow(startingRect.y + startingRect.height - matchRectangle.y, 2))/(matchRectangle.height) < 5) {
                  return findBox(new Rectangle(startingRect.x,startingRect.y,matchRectangle.x - startingRect.x + matchRectangle.width,matchRectangle.y - startingRect.y + matchRectangle.height),availableWords,wordsToFind.subList(1,wordsToFind.size()));
              }

          }
        }

        return null;
    }


}
