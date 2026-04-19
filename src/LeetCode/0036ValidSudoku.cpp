using namespace std;

#include <vector>

class Solution
{
public:
    bool isValidSudoku(vector<vector<char>> &board)
    {
        for (vector<char> row : board)
        {
            if (!checkRow(row))
                return false;
        };

        for (int i = 0; i < board.size(); i++)
        {
            if (!checkColumn(board, i))
                return false;
        }

        if (!checkSubBoxes(board))
            return false;

        return true;
    }

private:
    bool checkRow(vector<char> &row)
    {
        vector<int> nums(9);

        for (char &cell : row)
        {
            if (cell == '.')
            {
                continue;
            }

            int index = cell - '1';
            nums[index]++;
            if (nums[index] > 1)
            {
                return false;
            }
        }

        return true;
    }

private:
    bool checkColumn(vector<vector<char>> &board, int column)
    {
        vector<int> nums(9);

        for (int i = 0; i < board.size(); i++)
        {
            char &cell = board[i][column];

            if (cell == '.')
            {
                continue;
            }

            int index = cell - '1';
            nums[index]++;
            if (nums[index] > 1)
            {
                return false;
            }
        }

        return true;
    }

private:
    bool checkSubBoxes(vector<vector<char>> &board)
    {

        for (int i = 0; i < 9; i = i + 3)
        {
            for (int j = 0; j < 9; j = j + 3)
            {
                vector<int> nums(9);
                for (int x = 0; x < 3; x++)
                {
                    for (int y = 0; y < 3; y++)
                    {
                        char &cell = board[i + x][j + y];

                        if (cell == '.')
                        {
                            continue;
                        }

                        int index = cell - '1';
                        nums[index]++;
                        if (nums[index] > 1)
                        {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
};