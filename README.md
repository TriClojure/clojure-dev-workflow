# Clojure development workflow round-table

This repo houses a basic Clojure project with source files, unit tests, and
bare-bones configuration files for [Boot][boot], [Leiningen][lein], and the
[`clj`][cljcli] command-line tool.

This is intended as a jumping-off point for a round-table discussion about how
each of us approach development on a Clojure project.

Before the meetup, please clone this repo and play around with it a bit in your
development environment. Run the tests and/or experiment with the code at the
REPL. As you're doing this, think about your typical development workflow and
how you might answer the questions below.

## Running the tests

Depending on which build tool you prefer, you can run one of the following:

```
$ boot test
```

```
$ lein test
```

```
$ clj -Adev -m cognitect.test-runner
```

## Questions to spark discussion

1. What editor do you tend to use when developing Clojure?
2. How is your editor configured? Which plugins, if any, do you use?
3. How much do you use the REPL when developing? How do you start the REPL? Do you interact with it via your editor?
4. What are your thoughts on application state management frameworks (e.g. component, mount, integrant)? How do you use them (if at all) in your Clojure projects?
5. Where do you put scratch code?
6. How often do you write/run tests? What kinds of tests do you write?

[boot]: http://boot-clj.com/
[lein]: https://leiningen.org/
[cljcli]: https://clojure.org/guides/deps_and_cli

## License

Copyright © 2018 TriClojure

