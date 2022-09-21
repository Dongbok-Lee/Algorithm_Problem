#include<iostream>
#include<cstring>
#include<string>
#include<queue>

#define MAX 102
using namespace std;

int H, W, Answer;
char MAP[MAX][MAX];
bool Visit[MAX][MAX];
bool Key[26];

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

string First_Key;

void Initialize()
{
    memset(MAP, 0, sizeof(MAP));
    memset(Visit, false, sizeof(Visit));
    memset(Key, false, sizeof(Key));
    First_Key.clear();
    Answer = 0;
}

void Input()
{
    cin >> H >> W;
    for (int i = 1; i <= H; i++)
    {
        for (int j = 1; j <= W; j++)
        {
            cin >> MAP[i][j];
        }
    }

    cin >> First_Key;
    for (int i = 0; i < First_Key.length(); i++)
    {
        if (First_Key[i] == '0') continue;
        Key[First_Key[i] - 'a'] = true;
    }
}

void BFS(int a, int b)
{
    queue<pair<int, int>> q;
    queue<pair<int, int>> Door[26];
    q.push(make_pair(a, b));
    Visit[a][b] = true;

    while (q.empty() == 0)
    {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx <= H + 1 && ny <= W + 1)
            {
                if (MAP[nx][ny] == '*' || Visit[nx][ny] == true) continue;
                Visit[nx][ny] = true;

                if ('A' <= MAP[nx][ny] && MAP[nx][ny] <= 'Z')
                {
                    if (Key[MAP[nx][ny] - 'A'] == true)
                    {
                        q.push(make_pair(nx, ny));
                    }
                    else
                    {
                        Door[MAP[nx][ny] - 'A'].push(make_pair(nx, ny));
                    }
                }
                else if ('a' <= MAP[nx][ny] && MAP[nx][ny] <= 'z')
                {
                    q.push(make_pair(nx, ny));
                    if (Key[MAP[nx][ny] - 'a'] == false)
                    {
                        Key[MAP[nx][ny] - 'a'] = true;

                        while (Door[MAP[nx][ny] - 'a'].empty() == 0)
                        {
                            q.push(Door[MAP[nx][ny] - 'a'].front());
                            Door[MAP[nx][ny] - 'a'].pop();
                        }
                    }
                }
                else
                {
                    q.push(make_pair(nx, ny));
                    if (MAP[nx][ny] == '$') Answer++;
                }
            }
        }
    }
}

void Solution()
{
    BFS(0, 0);
}

void solve()
{
    int Tc;
    cin >> Tc;

    for (int T = 1; T <= Tc; T++)
    {
        Initialize();
        Input();
        Solution();
        cout << Answer << "\n";
    }
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    solve();

    return 0;
}
