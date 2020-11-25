local num=ARGV[1];
num=tonumber(num);
if(num > 20)
then
    redis.call('set',KEYS[1],'big num');
    return 'big num';
else
    redis.call('set',KEYS[1],'small num');
    return 'small num';
end