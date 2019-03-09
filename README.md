# clojure-tictactoe

Simple CLI tic-tac-toe in clojure

## Usage

Do `lein run`

Cells are marked from 0 to 8

## Example game

```
+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
Player X. Select a cell: 5

+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
Player O. Select a cell: 1

+---+ +---+ +---+
|   | | O | |   |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
Player X. Select a cell: 2

+---+ +---+ +---+
|   | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | |   |
+---+ +---+ +---+
Player O. Select a cell: 7

+---+ +---+ +---+
|   | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | | O | |   |
+---+ +---+ +---+
Player X. Select a cell: 6

+---+ +---+ +---+
|   | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
| X | | O | |   |
+---+ +---+ +---+
Player O. Select a cell: 6
This cell is taken. Try again!

+---+ +---+ +---+
|   | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
| X | | O | |   |
+---+ +---+ +---+
Player O. Select a cell: 0

+---+ +---+ +---+
| O | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
| X | | O | |   |
+---+ +---+ +---+
Player X. Select a cell: 2
This cell is taken. Try again!

+---+ +---+ +---+
| O | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | |   | | X |
+---+ +---+ +---+
+---+ +---+ +---+
| X | | O | |   |
+---+ +---+ +---+
Player X. Select a cell: 4

+---+ +---+ +---+
| O | | O | | X |
+---+ +---+ +---+
+---+ +---+ +---+
|   | | X | | X |
+---+ +---+ +---+
+---+ +---+ +---+
| X | | O | |   |
+---+ +---+ +---+
Player X have won!
```

## License

Copyright © 2019 tsumo

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
