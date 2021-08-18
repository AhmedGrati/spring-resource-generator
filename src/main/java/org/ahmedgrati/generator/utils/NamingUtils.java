package org.ahmedgrati.generator.utils;


import org.ahmedgrati.generator.schematics.Entity;
import org.ahmedgrati.generator.schematics.Repository;
import org.ahmedgrati.generator.schematics.Resource;
import org.ahmedgrati.generator.schematics.Service;
import org.ahmedgrati.generator.schematics.Controller;

public final class NamingUtils {
    private NamingUtils() {

    }

    /**
     * Given a resource and API Type, it returns the name of the package.
     * @param resource
     * @param apiTypeValues
     * @return String
     */
    public static String getPackageNameFromResourceAndAPIType(final Resource resource,
                                                              final APITypeValues apiTypeValues) {
        if (resource instanceof Entity) {
            return PackageNameConstants.ENTITIES_PACKAGE_NAME;
        }
        if (resource instanceof Repository) {
            return PackageNameConstants.REPOSITORIES_PACKAGE_NAME;
        }
        if (resource instanceof Service) {
            return PackageNameConstants.SERVICES_PACKAGE_NAME;
        }
        if (resource instanceof Controller) {

            if (apiTypeValues.getValue().equals(APITypeValues.REST.getValue())) {
                return PackageNameConstants.CONTROLLER_PACKAGE_NAME;
            }
            return PackageNameConstants.RESOLVER_PACKAGE_NAME;

        }
        return null;
    }
}
