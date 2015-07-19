### What

Forward pipe operator `|>`, as in F# and OCaml.

The original repository is [scalapipes](https://github.com/loverdos/scalapipes).

### Why
First, I did it for fun, while learning `F#` and it was a small design challenge to translate it into Scala. The pipe operator is mainstream now.  It *has* been since Unix time. `Ocaml` will have it builtin in its next version (I did not check, this could be live now).

I discovered the code to be more readable this way than the traditional `OO` dot chaining. Why? Because the flow is still natural (you start from the original data and you keep transforming them) and the intent is crystal clear: at each step you can actually understand both the flow of data and the flow of their respective types. I have not seen this noted elsewhere. This observation struck me as lightning and I think is of paramount importance for code readability.

Currently, I am using this at a couple of projects, trying to see how it scales.

### Details
This is the pipe operator in `OCaml` and `F#`:

    let (|>) x f = f x

and this is the translation I gave it for `Scala`:

    implicit final class MLPipe[T](val x: T) extends AnyVal {
        def |>[B](f: (T) => B) = f(x)
    }

So, any value is lifted to an object having the pipe operator built-in.

The implementation is deliberately kept *simple*, for now at least.

Type inference as served from the compiler may not be your best friend at all times.

Overall, the fun factor of doing this has been enormous.

### Motto
> Less is more. Use both with a pipe.
