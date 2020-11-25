local buyCount = ARGV[1];
buyCount = tonumber(buyCount);
local count = redis.call('get',KEYS[1]);
count = tonumber(count);
if(buyCount > count)
then
    return 'FAIL';
else
    count = count - buyCount;
    redis.call('set' , KEYS[1] , count);
    return 'SUCCESS';
end