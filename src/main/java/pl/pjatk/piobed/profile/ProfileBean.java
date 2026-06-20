package pl.pjatk.piobed.profile;

/**
 * Bean tworzony warunkowo - patrz ProfileBeanConfiguration.
 * Powstaje tylko gdy custom.enabled = true w application.yml.
 */
public class ProfileBean {

    public ProfileBean() {
        System.out.println("ProfileBean created");
    }
}
