
credentials ++= (for {
  username <- Option(System.getenv().get("SONATYPE_USERNAME"))
  password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
} yield
  Seq(Credentials(
    "Sonatype Nexus Repository Manager",
    "repo.smartii.co.uk",
    username,
    password))
  ).getOrElse(Seq())
