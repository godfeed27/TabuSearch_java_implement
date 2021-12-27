@echo off
mkdir data
mkdir optimalResults
curl "http://comopt.ifi.uni-heidelberg.de/software/TSPLIB95/tsp/ALL_tsp.tar.gz" --output data\ALL_tsp.tar.gz
winrar.exe e data\ALL_tsp.tar.gz -C data
Del "data\ALL_tsp.tar.gz"
winrar.exe e data\*.gz -C data
move "data\*.opt.tour" "optimalResults"
Del "data\*.gz"