#include<bits/stdc++.h>
using namespace std;

int K, N, sum;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    stack<int> st;

    cin >> K;
    for(int i=0; i<K; i++) {
        cin >> N;
        if(N == 0) {
            st.pop();
        }else {
            st.push(N);
        }
    }

    while(st.size()>0){
        sum = sum + st.top();
        st.pop();
    }
    cout << sum << "\n";
}
