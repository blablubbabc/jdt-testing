package org.bukkit;

import java.util.Map;

import org.bukkit.entity.Frog;
import org.eclipse.jdt.annotation.Nullable;

public class EeaTests {

	private static void registry() {
		Registry<Frog.Variant> registry = Registry.FROG_VARIANT;
		// Registry.get can return null.
		// External project can be assumed un-annotated (its jetbrains annotations are not
		// configured to be taken into account by Eclipse).
		// The package is annotated here (locally) as "NonNullByDefault", to apply a default to all
		// non-annotated external types (to not have to manually annotated the whole external
		// library).
		// Registry.get is explicitly annotated as nullable via EEA (see resources).
		// The EEA seems to be ignored in favor of the NonNullByDefault package declaration.
		Frog.@Nullable Variant variant = registry.get(NamespacedKey.minecraft("non_existent"));
		// Eclipse warning: "Null comparison always yields false: The variable variant cannot be
		// null at this location"
		if (variant == null) return;

		// Test annotating some Java type, such as Map.put: Works.
		Class<?> map = Map.class;
	}
}
