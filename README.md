# Formal Languages & Pattern Matching — Java Labs

Java coursework for **Języki Formalne i Techniki Translacji (JFiTT)**. The current laboratory implements two exact string-matching approaches: a finite-automaton matcher and Knuth–Morris–Pratt (KMP).

**Status:** coursework in progress. The repository currently contains [Laboratory 1](Laby1/), focused on exact string matching.

## Implementations

| Program | Approach |
| --- | --- |
| [FA](Laby1/src/main/java/pl/pattern/search/FA.java) | Builds a transition table for the pattern and scans the input using automaton states |
| [KMP](Laby1/src/main/java/pl/pattern/search/KMP.java) | Uses a longest-prefix-suffix table to continue matching after a mismatch |

Both programs read a text file and print zero-based starting positions of matching occurrences, including overlapping matches.

## Requirements

- JDK 21.
- Maven.

There are no external application dependencies in the laboratory's [pom.xml](Laby1/pom.xml).

## Compile and run

From the repository root:

```shell
cd Laby1
mvn compile
```

Then choose an implementation:

```shell
java -cp target/classes pl.pattern.search.FA "ABA" src/main/java/pl/pattern/search/files/test.txt
java -cp target/classes pl.pattern.search.KMP "ABA" src/main/java/pl/pattern/search/files/test.txt
```

The included file contains `ABABABA`, so the example matches begin at positions `0`, `2` and `4`. Console messages are in Polish.

For another input:

```shell
java -cp target/classes pl.pattern.search.KMP "<pattern>" "<path-to-text-file>"
```

Relative paths are resolved from the current working directory. Quote patterns and paths containing spaces.

## Current boundaries

- Use a non-empty pattern.
- The FA implementation indexes a 128-character transition table; use ASCII input for that program.
- These are educational command-line implementations, not a general-purpose text-search library.
- The current module does not include an automated test suite; `mvn compile` checks compilation.

## Repository contents

- [Laby1](Laby1/) — Maven project, both implementations and example input.
- [docs/git-checks.md](docs/git-checks.md) — Git verification notes.

The project demonstrates automaton construction, prefix-based matching and a small Java CLI with file input.
