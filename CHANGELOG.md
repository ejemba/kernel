# Version 1.0.M10 (???)

* [chg] The specs module is now without any dependency.
* [brk] Class specifications have been replaced by class predicates.
* [brk] Java 8 is now required.

# Version 1.0.M8 (???)

* [new] Kernel options are centralized in `KernelOptions`
* [new] Typed kernel configuration using `KernelOption`
* [chg] Disable Reflections logs by default
* [chg] Deprecate `pluginPackageRoot()` in `Plugin` and replace it by `rootPackages()`

# Version 1.0.M7 (2016-03-19)

* [chg] Replace sisu-guice by Guice 4
* [fix] Kernel params aliases
* [fix] Checks on mandatory kernel params

# Version 1.0.M6 (2015-11-7)

* [new] Add possibility for plugins to expose interface using `@Facet`
* [fix] Possible `OutOfMemoryError` when many kernel are started

# Version 1.0.M5 (2015-01-24)

* [chg] Upgrade Reflections to 0.9.10