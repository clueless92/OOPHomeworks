package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Unit;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;
import OOPSampleExam14Dec2015Empires.models.units.Archer;
import OOPSampleExam14Dec2015Empires.models.units.Swordsman;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UnitFactoryImpl implements UnitFactory {

    @Override
    public Unit createUnit(String unitType) {

//        List<Class> classList = null;
//        try {
//            classList = getClasses(this.getClass().getClassLoader(),
//                    "OOPSampleExam14Dec2015Empires.models.units");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (classList != null) {
//            for (Class c : classList) {
//                if (Objects.equals(c.getSimpleName(), unitType)) {
//                    try {
//                        Constructor<Unit> ctor = c.getConstructor();
//                        Unit unit = (Unit) ctor.newInstance();
//                        return unit;
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//        //throw new UnsupportedOperationException("Unsupported unit type.");
//        return null;

        switch (unitType) {
            case "Archer":
                return new Archer();
            case "Swordsman":
                return new Swordsman();
            default:
                throw new UnsupportedOperationException("Unsupported unit type.");
        }
    }

//    private static List<Class> getClasses(ClassLoader cl, String pack) throws Exception {
//
//        URL upackage = cl.getResource(pack);
//
//        BufferedReader br = null;
//        Object upackageContent = null;
//        if (upackage != null) {
//            upackageContent = upackage.getContent();
//        }
//        InputStreamReader isr = null;
//        if (upackageContent != null) {
//            isr = new InputStreamReader((InputStream) upackageContent);
//        }
//        if (isr != null) {
//            br = new BufferedReader(isr);
//        }
//        String dottedPackage = pack.replaceAll("[/]", ".");
//
//        List<Class> classes = new ArrayList<>();
//        String line = null;
//        if (br != null) {
//            line = br.readLine();
//        }
//        while (line != null) {
//            if(line.endsWith(".class")) {
//                int lastIndex = line.lastIndexOf('.');
//                if (lastIndex >= 0) {
//                    String className = dottedPackage + "." + line.substring(0, lastIndex);
//                    Class c = Class.forName(className);
//                    classes.add(c);
//                }
//            }
//            line = br.readLine();
//        }
//        return classes;
//    }
}