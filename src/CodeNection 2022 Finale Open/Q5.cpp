#include <bits/stdc++.h>
using namespace std;

const int MAXM = 200000 + 1;
const int MAXN = 5000 + 1;
int EdgeCount = 0, Head[MAXN], dis[MAXN], dis2[MAXN], n, r, t;
bool vis[MAXN];
queue<int> Q;
struct node
{
    int From, Next, Aim, Weight;
}Edge[MAXM];

void Insert(int u, int v, int w)
{
    Edge[++EdgeCount] = (node){u,Head[u],v,w};
    Head[u] = EdgeCount;
}
void SPFA(int s, int t, int *dis)
{
    while(!Q.empty())
        Q.pop();
    Q.push(s);
    dis[s] = 0;
    memset(vis,false,sizeof(vis));
    vis[s] = true;
    while(!Q.empty())
    {
        int p = Q.front();
        Q.pop();
        vis[p] = false;
        for (int i = Head[p]; i; i = Edge[i].Next)
        {
            int m = Edge[i].Aim;
            if (dis[p]+Edge[i].Weight < dis[m])
            {
                dis[m] = dis[p] + Edge[i].Weight;
                if (!vis[m])
                {
                    Q.push(m);
                    vis[m] = 1;
                }
            }
        }
    }
}

int main()
{
    cin >> t;
    cin >> n >> r;
    for(int i = 1; i <= t; i++){
    int u, v, w;
    EdgeCount = 0;
    memset(Head, 0, sizeof Head);
    memset(dis, 0, sizeof dis);
    memset(dis2, 0, sizeof dis2);
    memset(vis, false, sizeof vis);
    queue<int> empty;
    swap(Q, empty );
        for (int i = 1; i <= r; i++)
        {
            cin >> u >> v >> w;
            Insert(u,v,w);
            Insert(v,u,w);
        }
        memset(dis,0x3F,sizeof(dis));
        SPFA(1,n,dis);
        int ShortestPathLength = dis[n];
        int SecondShortest = 2147483647;
        memset(dis2,0x3F,sizeof(dis2));
        SPFA(n,1,dis2);
        for(int i = 1; i <= EdgeCount; i++)
            if(dis[Edge[i].From]+dis2[Edge[i].Aim]+Edge[i].Weight > ShortestPathLength)
                SecondShortest = min(dis[Edge[i].From]+dis2[Edge[i].Aim]+Edge[i].Weight, SecondShortest);
        cout << SecondShortest << endl;
    }
}