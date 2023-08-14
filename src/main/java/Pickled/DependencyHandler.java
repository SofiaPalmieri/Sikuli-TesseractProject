package Pickled;

import PickledExceptions.PickledMissingFileException;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;

import java.net.URL;

public class DependencyHandler {

    private static DependencyHandler instance;

    static public DependencyHandler getInstance() {
        if (instance == null) {
            instance = new DependencyHandler();
        }
        return instance;
    }

    public void loadDependencies(){
        nu.pattern.OpenCV.loadLocally();
    }

    public String getImage(String name){
        return this.getFullPath(name + ".png");
    }

    public ITesseract getTesseract(){
        ITesseract iTesseract =  new Tesseract();
        iTesseract.setDatapath("C:/Users/lautaro.moyano/IdeaProjects/PickledEggplant/src/main/resources/tessdata");
        iTesseract.setLanguage("eng");
        iTesseract.setVariable("user_defined_dpi", "96");
        iTesseract.setVariable("tessedit_pageseg_mode", "11");
        return  iTesseract;
    }

    public String getFullPath(String content) throws PickledMissingFileException {
        ClassLoader classLoader = Image.class.getClassLoader();
        URL resource = classLoader.getResource(content);
        System.out.println(resource);
        if (resource != null) {
            return resource.getPath();
        } else {
            throw new PickledMissingFileException();
        }
    }

    private DependencyHandler(){
    }








}
