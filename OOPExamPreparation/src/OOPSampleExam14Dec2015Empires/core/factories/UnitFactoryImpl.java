package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Unit;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;
import OOPSampleExam14Dec2015Empires.core.MyReflection;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UnitFactoryImpl implements UnitFactory {

    @Override
    public Unit createUnit(String unitType) {

        final String pack = "OOPSampleExam14Dec2015Empires.models.units";
        Collection<Class> classList = new ArrayList<>();
        Constructor[] ctors = null;
        Unit unit = null;
        try {
            classList = MyReflection.getClasses(pack);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Class c : classList) {
            if ((c.getSimpleName().toLowerCase()).equals(unitType.toLowerCase())) {
                ctors = c.getConstructors();
                if (ctors != null) {
                    try {
                        unit = (Unit) ctors[0].newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return unit;

//        switch (unitType) {
//            case "Archer":
//                return new Archer();
//            case "Swordsman":
//                return new Swordsman();
//            default:
//                throw new UnsupportedOperationException("Unsupported unit type.");
//        }
    }
}