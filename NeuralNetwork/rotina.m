n = 600;

[noises,target] = generateVectorNoises(n);

% target = cos(0:0.01:2*pi)';
% entrada = (0:0.01:2*pi)';

file_1 = fopen('output2.txt','w');

for i= 1:n
    fprintf(file_1,'%5.3f %5.3f %5.3f %5.3f %5.3f %5.3f\n',noises(i,:),target(i,:));  
end

fclose(file_1);
 