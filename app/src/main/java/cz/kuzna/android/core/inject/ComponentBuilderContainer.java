package cz.kuzna.android.core.inject;

/**
 * @author Radek Kuznik
 */
public interface ComponentBuilderContainer {

    ComponentBuilder getComponentBuilder(Class<?> clazz);
}