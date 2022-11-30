#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

int main(void)
{
	int trials[] = {16, 17, 4, 3, 5, 2};
	int leaders[10];
	int current;
	int ahead = current + 1;

	leaders.push_back(trials[-1]);
	//bruteForceApproach (On^2)
	for (current = 0; current < sizeof(trials); current++)
	{
		for (ahead; ahead <= sizeof(trials); ahead++)
		{
			if (trials[current] < trials[ahead])
			{
				break;
			}
			if (ahead == sizeof(trials))
			{
				leaders.push_back(trials[current]);
			}
		}
	}
	std::cout << leaders;

	return (0);
}