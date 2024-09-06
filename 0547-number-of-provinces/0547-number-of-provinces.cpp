class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        vector<bool> visited(isConnected.size());
        int province = 0, next = 0;
        queue<int> q;
        while(next != -1){
            province++;
            q.push(next);
            visited[next] = true;
            while(!q.empty()){
                int temp = q.front();
                q.pop();
                for(int i = 0; i < isConnected.size(); i++){
                    if(isConnected[temp][i] && i !=next && !visited[i]){
                        visited[i] = true;
                        q.push(i);
                    }
                }
            }

            next = -1;
            for(int i = 0; i < visited.size(); i++){
                if(visited[i] == false){
                    next = i;
                    break;
                }
            }
        }
        return province;
    }
};