#include<bits/stdc++.h>
using namespace std;

int tc, N, M, pri;




int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> tc;

    for(int i=0; i<tc; i++) {
    	queue<pair<int, bool> > que;
    	priority_queue<int> pq;
        int count = 0;
        
        cin >> N >> M;
        
        for(int j = 0; j<N; j++) {
            cin >> pri;
            pq.push(pri);
        if(j==M) {
            que.push(make_pair(pri, true));
        }
            que.push(make_pair(pri, false));
        }
        
      while(!que.empty()) {
      	int value = que.front().first;
      	bool flag = que.front().second;
      	que.pop();
      	
      	if(pq.top() == value) {
      		pq.pop();
      		++count;
      		if(flag) {
      			cout << count << "\n";
      			break;
			  }
		  }else {
		  	que.push({value, flag});
		  }
	  }
    }
}


