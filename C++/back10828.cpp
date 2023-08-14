#include<bits/stdc++.h>
using namespace std;

int N, X;
string cmd;
int main() {
    stack<int> st;

    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> cmd;
        if(cmd == "push") {
            cin >> X;
            st.push(X);
        }else if(cmd == "pop") {
            if(st.size()==0) {
                cout << -1 << "\n";
            } else {
                cout << st.top() << "\n";
                st.pop();
            }
        }else if(cmd == "size") {
            cout << st.size() << "\n";
        }else if(cmd == "empty") {
            if(st.empty()) cout << 1 << "\n";
            else cout << 0 << "\n";
        }else if(cmd == "top") {
            if(st.size()==0) {
                cout << -1 << "\n";
            } else {
            cout << st.top() << "\n";
            }
        }
    }

}
