#include<bits/stdc++.h>
using namespace std;

int N, x;

priority_queue<int> que;


int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> x;
        que.push(x);
        if(x==0) {
            if(que.empty()) cout << 0 << "\n";
            else {
                    cout << que.top() << "\n";
                    que.pop();
            }
        }
    }
}
