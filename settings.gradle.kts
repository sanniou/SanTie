rootProject.buildFileName = "build.gradle.kts"

include(":app", ":support", ":multiitemkit", ":multiitem")
project(":support").projectDir = File("SanSupport/support")
project(":multiitemkit").projectDir = File("SanSupport/MultiItemKit/multiitemkit")
project(":multiitem").projectDir = File("SanSupport/MultiItemKit/multiitem")