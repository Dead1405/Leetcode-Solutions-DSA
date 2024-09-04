#include <vector>
#include <unordered_map>
#include <set>
#include <cmath>
using namespace std;

class Solution {
public:
    long long int distCalc(const long long int x, const long long int y) {
        return pow(x, 2) + pow(y, 2);
    }

    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        int drn[][2] = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirn = 0;
        unordered_map<int, set<int>> xy;
        unordered_map<int, set<int>> yx;
        
        for(int i = 0; i < obstacles.size(); i++) {
            xy[obstacles[i][0]].insert(obstacles[i][1]);
            yx[obstacles[i][1]].insert(obstacles[i][0]);
        }

        long long int maxDist = 0;
        long long int xposn = 0, yposn = 0;
        
        for (int i = 0; i < commands.size(); i++) {
            switch (commands[i]) {
                case -1:
                    dirn = (dirn + 1) % 4;
                    break;
                case -2:
                    dirn = (dirn + 3) % 4;
                    break;
                default:
                    int xdirn = drn[dirn][0];
                    int ydirn = drn[dirn][1];
                    int steps = commands[i];
                    
                    if(xdirn == 0) {  // Moving north or south
                        int yexpected = yposn + ydirn * steps;
                        if(ydirn == 1) {  // Moving north
                            for(auto it : xy[xposn]) {
                                if(it > yposn && it <= yexpected) {
                                    yexpected = it - 1;
                                    break;
                                }
                            }
                        } else {  // Moving south
                            for(auto it = xy[xposn].rbegin(); it != xy[xposn].rend(); ++it) {
                                if(*it < yposn && *it >= yexpected) {
                                    yexpected = *it + 1;
                                    break;
                                }
                            }
                        }
                        yposn = yexpected;
                    } else {  // Moving east or west
                        int xexpected = xposn + xdirn * steps;
                        if(xdirn == 1) {  // Moving east
                            for(auto it : yx[yposn]) {
                                if(it > xposn && it <= xexpected) {
                                    xexpected = it - 1;
                                    break;
                                }
                            }
                        } else {  // Moving west
                            for(auto it = yx[yposn].rbegin(); it != yx[yposn].rend(); ++it) {
                                if(*it < xposn && *it >= xexpected) {
                                    xexpected = *it + 1;
                                    break;
                                }
                            }
                        }
                        xposn = xexpected;
                    }

                    long long int dist = distCalc(xposn, yposn);
                    if(maxDist < dist) maxDist = dist;
            }
        }
        return maxDist;
    }
};
