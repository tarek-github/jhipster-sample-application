package fr.cnrs.dsi.sesame.frontend;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("fr.cnrs.dsi.sesame.frontend");

        noClasses()
            .that()
            .resideInAnyPackage("fr.cnrs.dsi.sesame.frontend.service..")
            .or()
            .resideInAnyPackage("fr.cnrs.dsi.sesame.frontend.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..fr.cnrs.dsi.sesame.frontend.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
