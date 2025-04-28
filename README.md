This is a fork of the [gradle issue reproducer](https://github.com/gradle/gradle-issue-reproducer) to demonstrate what appears to be a bug with configure-on-demand

# Step to repro

1. `./gradlew test-project:sub-project:integrationTest`

# Expected result

- The task runs successfully

# Actual result

- The task fails with this:

```
* What went wrong:
Could not determine the dependencies of task ':test-project:sub-project:integrationTest'.
> A problem occurred configuring project ':dep-project:service'.
   > org.gradle.api.internal.initialization.DefaultClassLoaderScope@ebe1be8 must be locked before it can be used to compute a classpath!
```

# Notes

Inside `test-project/sub-project/build.gradle.kts` there are two task dependencies. The uncommented one produces an error, the commented one does not. The two tasks are identical, the only difference is that one is in a "deeper" project (`:foo:bar`) while the other one is in a shallower project (`:foo`). Why should this matter? I dunno, but it seems like a gradle bug.
