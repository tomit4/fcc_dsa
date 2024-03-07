## Free Code Camp Data Structures & Algorithms (48 hour course)

### Introduction

This is a follow along of Free Code Camp's [Data Structures and Algorithms in 48
hours](https://www.youtube.com/watch?v=2ZLl8GAk1X4&pp=ygUtZnJlZSBjb2RlIGNhbXAgZGF0YSBzdHJ1Y3R1cmVzIGFuZCBhbGdvcml0aG1z).

### Arch Linux Specific Needs For Java Development

You'll need to ensure that `archlinux-java set` is the same as using the javac
compiler (21 at the time of this writing)

```bash
archlinux-java status
```

```bash
archlinux-java set java-21-openjdk
```

```bash
java -version
```

To compile the program using the javac compiler:

```bash
javac hello_world.java
```

This will create the file named HelloWorld.class

And then use the java runtime to run the program:

```bash
java HelloWorld # prints "Hello World!"
```
