import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

//dados do gráfico
type CharData = {
    labels: string[];
    series: number[];
}

//gráfico de rosca
const DonutChart = () => {

    const [charData, setChartData] = useState<CharData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(response => {

                const data = response.data as SaleSum[];
                const myLabels = data.map(x => x.sellerName);
                const mySeries = data.map(x => x.sum);

                setChartData({ labels: myLabels, series: mySeries });

                console.log(charData);

            });

    }, [])


    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: charData.labels }}
            series={charData.series}
            type="donut"
            height="240"
        />

    );
}

export default DonutChart;