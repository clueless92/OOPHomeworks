package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Building;
import OOPSampleExam14Dec2015Empires.contracts.BuildingFactory;
import OOPSampleExam14Dec2015Empires.contracts.ResourceFactory;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;
import OOPSampleExam14Dec2015Empires.models.buildings.Archery;
import OOPSampleExam14Dec2015Empires.models.buildings.Barracks;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BuildingFactoryImpl implements BuildingFactory {

    @Override
    public Building createBuilding(String buildingType, UnitFactory unitFactory, ResourceFactory resourceFactory) {

        switch (buildingType) {
            case "barracks":
                return new Barracks(unitFactory, resourceFactory);
            case "archery":
                return new Archery(unitFactory, resourceFactory);
            default:
                throw new UnsupportedOperationException("Unknown building type");
        }
    }

    private static List<Class> getClasses(ClassLoader cl,String pack) throws Exception{

        URL upackage = cl.getResource(pack);

        BufferedReader br = null;
        Object upackageContent = null;
        if (upackage != null) {
            upackageContent = upackage.getContent();
        }
        InputStreamReader isr = null;
        if (upackageContent != null) {
            isr = new InputStreamReader((InputStream) upackageContent);
        }
        if (isr != null) {
            br = new BufferedReader(isr);
        }
        String dottedPackage = pack.replaceAll("[/]", ".");

        List<Class> classes = new ArrayList<>();
        String line = null;
        if (br != null) {
            line = br.readLine();
        }
        while (line != null) {
            if(line.endsWith(".class")) {
                int lastIndex = line.lastIndexOf('.');
                if (lastIndex >= 0) {
                    String className = dottedPackage + "." + line.substring(0, lastIndex);
                    Class c = Class.forName(className);
                    classes.add(c);
                }
            }
            line = br.readLine();
        }
        return classes;
    }
}