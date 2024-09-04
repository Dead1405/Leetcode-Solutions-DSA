

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

        long long int max = 0;
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
                    // Moving in north or south direction
                    if(xdirn == 0) {
                        int yfound = 0;
                        int yexpected = yposn + ydirn * commands[i];
                        if(ydirn == 1) {
                            for(auto it : xy[xposn]) {
                                if(it > yposn && it <= yexpected) {
                                    yexpected = it-1;
                                    break;
                                }
                            }
                        } else {
                            for(auto it = xy[xposn].rbegin(); it != xy[xposn].rend(); ++it) {
                                if(*it < yposn && *it >= yexpected) {
                                    yexpected = *it+1;
                                    break;
                                }
                            }
                        }
                        yposn = yexpected;
                    } else {
                        int xfound = 0;
                        int xexpected = xposn + xdirn * commands[i];
                        if(xdirn == 1) {
                            for(auto it : yx[yposn]) {
                                if(it > xposn && it <= xexpected) {
                                    xexpected = it - 1;
                                    break;
                                }
                            }
                        } else{
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
                    if(max < dist) max = dist;
            }
            cout << xposn <<" "<<yposn << endl;
        }
        return max;
    }
};
