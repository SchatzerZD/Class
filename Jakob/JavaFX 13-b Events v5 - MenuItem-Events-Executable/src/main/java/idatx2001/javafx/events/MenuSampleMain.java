package idatx2001.javafx.events;

/**
 * For the JVM to be able to fully identify the main entry point of the
 * application, it is required that the main()-method is located in a
 * non-JavaFX class.
 * I.e. this class only serves as a "clean" non-JavaFX starting point, enabling
 * the creation of an executable JAR, and also resolving the
 * "JavaFX runtime could not be found" message.
 */
public class MenuSampleMain {
  public static void main(String[] args) {
    MenuSample.main(args);
  }
}
