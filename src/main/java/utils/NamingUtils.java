package utils;

import schematics.*;

public class NamingUtils {
    public static String getPackageNameFromResourceAndAPIType(Resource resource, APITypeValues apiTypeValues) {
        if(resource instanceof Entity) {
            return PackageNameConstants.ENTITIES_PACKAGE_NAME;
        }
        if(resource instanceof Repository) {
            return PackageNameConstants.REPOSITORIES_PACKAGE_NAME;
        }
        if(resource instanceof Service) {
            return PackageNameConstants.SERVICES_PACKAGE_NAME;
        }
        if(resource instanceof Controller){

            if(apiTypeValues.getValue().equals(APITypeValues.REST.getValue())) {
                return PackageNameConstants.CONTROLLER_PACKAGE_NAME;
            }
            return PackageNameConstants.RESOLVER_PACKAGE_NAME;

        }
        return null;
    }
}
