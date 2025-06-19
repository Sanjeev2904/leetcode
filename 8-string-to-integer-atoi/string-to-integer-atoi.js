var myAtoi = function(s) {
    s = s.trim(); // Remove leading whitespace
    if (s.length === 0) return 0;

    let sign = 1, i = 0, res = 0;

    // Check for sign
    if (s[i] === '-') { sign = -1; i++; }
    else if (s[i] === '+') { i++; }

    // Process numerical characters
    while (i < s.length && s[i] >= '0' && s[i] <= '9') {
        res = res * 10 + (s[i] - '0');

        // Handle overflow
        if (sign * res > 2**31 - 1) return 2**31 - 1;
        if (sign * res < -(2**31)) return -(2**31);

        i++;
    }

    return sign * res;
};