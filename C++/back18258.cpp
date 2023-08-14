#include<bits/stdc++.h>
using namespace std;

int N, X;
string cmd;

queue<int> que;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> cmd;
        if(cmd == "push") {
            cin >> X;
            que.push(X);
        }else if(cmd == "pop") {
            if(que.size()==0) {
                cout << -1 << "\n";
            } else {
                cout << que.front() << "\n";
                que.pop();
            }
        }else if(cmd == "size") {
            cout << que.size() << "\n";
        }else if(cmd == "empty") {
            if(que.empty()) cout << 1 << "\n";
            else cout << 0 << "\n";
        }else if(cmd == "front") {
            if(que.size()==0) {
                cout << -1 << "\n";
            } else {
            cout << que.front() << "\n";
            }
        }else if(cmd == "back") {
            if(que.size()==0) {
                cout << -1 << "\n";
            } else {
            cout << que.back() << "\n";
            }
        }
    }

}
