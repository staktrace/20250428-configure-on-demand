tasks.register("integrationTest", Test::class.java) {
  dependsOn(":dep-project:service:depTask")
}
