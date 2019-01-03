name := "tiny-types"

lazy val tinyTypes = Project(
  id   = "tiny-types",
  base = file(".")
).aggregate(
  tinyTypesCore,
  tinyTypesCoreTests
).settings(
  commonSettings
).enablePlugins(
  AutomateHeaderPlugin
)

lazy val tinyTypesCore = Project(
  id   = "tiny-types-core",
  base = file("tiny-types-core")
).settings(
  commonSettings
).enablePlugins(
  AutomateHeaderPlugin
)

lazy val tinyTypesCoreTests = Project(
  id   = "tiny-types-core-tests",
  base = file("tiny-types-core-tests")
).settings(
  commonSettings
).dependsOn(
  tinyTypesCore % "compile->compile;test->test"
).enablePlugins(
  AutomateHeaderPlugin
)

lazy val commonSettings = Seq(
  organization := "org.amdg",
  version      := "0.0.1-SNAPSHOT",
  scalaVersion := "2.12.8",

  organizationName := "AMDG Solutions",
  startYear        := Some(java.time.LocalDate.now().getYear),
  licenses         += ("Apache-2.0", new URL("https://www.apache.org/licenses/LICENSE-2.0.txt"))
)
