plugins {
  id("java")
}

tasks.register("integrationTest", Test::class.java) {
  dependsOn(":dep-project:service:depTask") // <-- this fails with org.gradle.api.internal.initialization.DefaultClassLoaderScope@72c766e6 must be locked before it can be used to compute a classpath!
  // dependsOn(":shallow-project:depTask") // <-- this works just fine
}
