long long sum(int *a, int n) {
	long long ans = 0;
    int b;
    for(b=0; b<n; b++)
    {
      ans+=a[b]; 
    }
	return ans;
}
