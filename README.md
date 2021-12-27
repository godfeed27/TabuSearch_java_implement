# TabuSearch_java_implement
### Folder Structure

The workspace contains five folders, where:

- `bin`: contains classes after compile
- `data`: contains data instances
- `lib`: contains dependencies
- `output`: contains output files
- `src`: contains sources

### Data Description

Data
http://comopt.ifi.uni-heidelberg.de/software/TSPLIB95/tsp/

Large data
http://www.math.uwaterloo.ca/tsp/world/countries.html

Data description
http://comopt.ifi.uni-heidelberg.de/software/TSPLIB95/tsp95.pdf

Data FAQ
http://comopt.ifi.uni-heidelberg.de/software/TSPLIB95/TSPFAQ.html

One can download the datasets `.tsp`, `.opt.tsp` from [here](http://comopt.ifi.uni-heidelberg.de/software/TSPLIB95/tsp/ALL_tsp.tar.gz) by:
- For Windows:
    - Install [winrar](https://www.win-rar.com/start.html?&L=10) and set path:
        ```
        set path="path\to\WinRAR\";%path%
        ```
    - Run `getData-Win.bat`:
        ```console
        > getData-Win.bat
        ```
- For Linux/MacOS:
    - Install `curl`:
        ```
        > sudo apt install curl
        ```
    - Run getData-Unix.sh:
        ```
        > bash getData-Unix.sh
        ```

## Installation

### 