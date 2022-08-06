#include <iostream>
#include <unordered_map>

using namespace std;

class HashMap
{
    unordered_map<int, int> map;

public:
    void put(int key, int value) { map[key] = value; }
    int get(int key) { return map[key]; }
};

class Bf
{
    HashMap _t = HashMap();
    int _p = 0;

public:
    int c() { return _t.get(_p); }      // current
    void p() { _t.put(_p, c() + 1); }   // plus, increment
    void m() { _t.put(_p, c() - 1); }   // minus, decrement
    void l() { _p--; }                  // left
    void r() { _p++; }                  // right
    void o() { cout << (char)c(); }     // out, print
    void i() { _t.put(_p, getchar()); } // in, read
};

void impl(Bf b)
{
    // implement the program here
}

int main()
{
    Bf b;
    impl(b);
    return 0;
};
