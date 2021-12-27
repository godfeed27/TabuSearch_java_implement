mkdir -p data
mkdir -p optimalResults
curl http://comopt.ifi.uni-heidelberg.de/software/TSPLIB95/tsp/ALL_tsp.tar.gz --output data/ALL_tsp.tar.gz
tar -xzf data/ALL_tsp.tar.gz -C data
rm data/ALL_tsp.tar.gz
gzip -d data/*.gz
mv data/*opt.tour optimalResults  
