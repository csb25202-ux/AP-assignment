#include<iostream>
#include<time.h>
using namespace std;

void linear(int n){
    int a =0;
    for(int i=0;i<=n;i++){ 
        a = a + i; 
    } 
    cout<<endl;
    return;
}

void constant(int n){
    int a = 5+2;
    cout<<endl;
    return ;
}

void quadratic(int n){
    for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
        }
    } cout<<endl;
    return ;
}

void logarithmic(int n){
    while(n>=1){
        n = n/2;
    }
    cout<<endl; 
    return ;
}

int main(){
    int n;
    cin>>n;
    cout<<"input : "<<n<<endl;;

    clock_t constant_st = clock();
    constant(n);
    clock_t constant_end = clock();
    double time_constant = (double)constant_end - (double)constant_st;
    cout<<"time for the case of constant : "<<time_constant<<endl;

    clock_t logarithmic_st = clock();
    logarithmic(n);
    clock_t logarithmic_end = clock();
    double time_logarithmic = (double)logarithmic_end - (double)logarithmic_st;
    cout<<"time for the case of logarithmic : "<<time_logarithmic<<endl;
    
    clock_t linear_st = clock();
    linear(n);
    clock_t linear_end = clock();
    double time_linear = (double)linear_end - (double)linear_st;
    cout<<"time for the case of linear : "<<time_linear<<endl;

    clock_t quadratic_st = clock();
    quadratic(n);
    clock_t quadratic_end = clock();
    double time_quadratic = (double)quadratic_end - (double)quadratic_st;
    cout<<"time for the case of quadratic : "<<time_quadratic<<endl;

}