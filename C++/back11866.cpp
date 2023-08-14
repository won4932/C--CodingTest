#include<bits/stdc++.h>
using namespace std;

int N, K;

queue<int> que;

int x = 0;
int y = 0;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;

    int it[N-1];

    for(int i=1; i<=N; i++) {
        que.push(i);
    }

    while(que.size()>0) {
        x++;
        if(x==K) {
            x=0;
            it[y] = que.front();
            y++;
        }else {
        que.push(que.front());
        }
        que.pop();

    }
    cout << "<";
    for(int i = 0; i<N; i++) {
        if(i == N-1) cout << it[i] << ">";
        else cout << it[i] << ", ";
    }

}
