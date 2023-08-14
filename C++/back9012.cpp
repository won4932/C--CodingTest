#include<bits/stdc++.h>
using namespace std;

int T;
string VPS;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    stack<int> st;

    cin >> T;
    for(int i=0; i<T; i++) {
        cin >> VPS;
        st.push(VPS);
        if(VPS == "(") {


        }
    }

    while(st.size()>0){
        sum = sum + st.top();
        st.pop();
    }
    cout << sum << "\n";
}
