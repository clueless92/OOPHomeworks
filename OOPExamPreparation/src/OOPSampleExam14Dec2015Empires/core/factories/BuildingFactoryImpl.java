package OOPSampleExam14Dec2015Empires.core.factories;

import OOPSampleExam14Dec2015Empires.contracts.Building;
import OOPSampleExam14Dec2015Empires.contracts.BuildingFactory;
import OOPSampleExam14Dec2015Empires.contracts.ResourceFactory;
import OOPSampleExam14Dec2015Empires.contracts.UnitFactory;
import OOPSampleExam14Dec2015Empires.core.MyReflection;
import OOPSampleExam14Dec2015Empires.models.buildings.Archery;
import OOPSampleExam14Dec2015Empires.models.buildings.Barracks;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BuildingFactoryImpl implements BuildingFactory {

    @Override
    public Building createBuilding(String buildingType, UnitFactory unitFactory, ResourceFactory resourceFactory) {

        final String pack = "OOPSampleExam14Dec2015Empires.models.buildings";
        Collection<Class> classList = new ArrayList<>();
        Constructor[] ctors = null;
        Building building = null;
        try {
            classList = MyReflection.getClasses(pack);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Class c : classList) {
            if ((c.getSimpleName().toLowerCase()).equals(buildingType)) {
                ctors = c.getConstructors();
                if (ctors != null) {
                    try {
                        building = (Building) ctors[0].newInstance(unitFactory, resourceFactory);
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
        return building;
//        switch (buildingType) {
//            case "barracks":
//                return new Barracks(unitFactory, resourceFactory);
//            case "archery":
//                return new Archery(unitFactory, resourceFactory);
//            default:
//                throw new UnsupportedOperationException("Unknown building type");
//        }
    }
}