#include<bits/stdc++.h>
using namespace std;

int tc, N, M, pri;

queue<pair<int, bool>> que;


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> tc;

    for(int i=0; i<tc; i++) {
        int temp = 0;
        cin >> N >> M;
        for(int j = 0; j<N; i++) {
            cin >> pri;
        if(j==M) {
            temp = pri;
            que.push(pri, true);
        }
            que.push(pri, false);
        }

        for(int k = 0; k<que.size(); k++) {

        }
    while(1) {
        if(temp<que.top()) {
            count++;
            que.pop();
        }
        else {
            que.push_back(que.top());
            que.pop();
        }

    }

    }
}

