/*
 * Copyright (c) 2013-2014 Christos KK Loverdos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/**
 * Forward pipe operator, as in F# and OCaml.
 *
 * @author Christos KK Loverdos <loverdos@gmail.com>
 */
package object mlpipe {
  // let (|>) x f = f x
  implicit final class MLPipe[T](val x: T) extends AnyVal {
    def |>[B](f: (T) ⇒ B) = f(x)
  }
}
