# mirNer
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
## Description

mirNer is a simple regex based tool to detect MicroRna mentions in text, following the mi-RNA definition of Victor Ambroset al., (2003). A uniform system for microRNA annotation. RNA 2003 9(3):277-279.

## Usage:
### Maven Import:
Add a new repository pointing to jitpack.
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```

And add the following dependenc

```xml
	<dependency>
	    <groupId>com.github.Erechtheus</groupId>
	    <artifactId>mirNer</artifactId>
	    <version>master-SNAPSHOT</version>
	</dependency>
```

### Java example
```java
    public static void main(String[] args){
        String text = "We detected the following mirna hsa-miR-216a* in human cel-lines.";
        MirNer mir = new MirNer();
        System.out.println(mir.extractFromText(text));
    }
```
